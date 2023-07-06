package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Bid;
import app.core.entities.Company;
import app.core.exceptions.BidsException;
import app.core.exceptions.CompaniesException;
import app.core.repositories.BidRepo;
import app.core.repositories.CompanyRepo;

/**
 * @author adido
 *
 */
@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private BidRepo bidRepo;

	public Company addCompany(Company company) throws CompaniesException {
		if (!this.companyRepo.existsById(company.getId())) {
			this.companyRepo.save(company);
			return company;
		} else {
			throw new CompaniesException(
					"addCompany failed - a company with this name already exists: " + company.getName());
		}
	}
	
	public Bid addBidToCompany(Company company, Bid bid) throws BidsException{
//		company.addCoupon(coupon);
		bid.setCompany(company);
		bidRepo.save(bid);
		return bid;
	}
	public Company getCompanyDetails(int companyId) throws CompaniesException {
		return companyRepo.findById(companyId)
				.orElseThrow(() -> new CompaniesException("getCompanyDetails failed - not found"));
	}
//	public Coupon addCouponToCompany(int companyId, Coupon coupon) throws CouponsException {
//		if (!this.couponRepo.existsById(coupon.getId())) {
//			Company company = companyRepo.findById(companyId)
//					.orElseThrow(() -> new CompaniesException("Company id: " + companyId + " not found"));
//			company.addCoupon(coupon);
//			companyRepo.save(company);
////			coupon.setCompany(company);
//			return coupon;
//		} else {
//			throw new CouponsException(
//					"addCouponToCompany failed - a coupon with this id already exists" + coupon.getId());
//		}
//	}


//	public Coupon updateCoupon(int companyId, Coupon coupon) throws CouponsException {
//		coupon.setCompany(getCompanyDetails(companyId));
//		coupon.setCustomers(getCouponById(companyId, coupon.getId()).getCustomers());
//		return couponRepo.save(coupon);
//	}
//
//	/**
//	 * @param couponId
//	 * @return coupon
//	 * @throws CouponsException if the specified coupon not exists
//	 */
//	public Coupon getCouponById(int companyId, int couponId) throws CouponsException {
//		Coupon coupon = couponRepo.findById(couponId)
//				.orElseThrow(() -> new CouponsException("Coupon Id: " + couponId + " not found "));
////		if (coupon.getCompanyId() != companyId) {
////			throw new CouponsException("This coupon does not belong to company id: " + companyId);
////		}
//		return coupon;
//	}
//
//	public void deleteCouponById(int companyId, int couponId) throws CouponsException {
//		Coupon coupon = couponRepo.findById(couponId)
//				.orElseThrow(() -> new CouponsException("Coupon Id: " + couponId + " not found "));
////		if (coupon.getCompanyId() != companyId) {
////			throw new CouponsException("This coupon does not belong to company id: " + companyId);
////		}
//		couponRepo.delete(coupon);
//	}
//
//	public List<Coupon> getCouponsForCompany(int companyId) {
//		return companyRepo.findById(companyId).get().getCoupons();
//	}
//
//	public List<Coupon> getAllCompanyCouponsByCategory(int companyId, Category category) {
//		return couponRepo.findAllByCompanyIdAndCategory(companyId, category);
//	}
//
//	public List<Coupon> getAllCompanyCouponsLessThanMaxPrice(int companyId, double maxPrice) {
//		List<Coupon> coupons = couponRepo.findAllByCompanyIdAndPriceLessThan(companyId, maxPrice);
//		return coupons;
//	}
//
//	/**
//	 * @param coupon
//	 * @return
//	 * @throws CouponsException if the specified coupon not exists
//	 */
//
//	public Company getCompanyDetails(int companyId) throws CompaniesException {
//		return companyRepo.findById(companyId)
//				.orElseThrow(() -> new CompaniesException("getCompanyDetails failed - not found"));
//	}

}
